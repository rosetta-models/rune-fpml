package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxKnockoutCount;
import fpml.confirmation.FxKnockoutLevel;
import fpml.confirmation.FxTarget;
import fpml.confirmation.FxTargetAccumulationRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetValidator implements Validator<FxTarget> {

	private List<ComparisonResult> getComparisonResults(FxTarget o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accumulationRegion", (List<? extends FxTargetAccumulationRegion>) o.getAccumulationRegion() == null ? 0 : ((List<? extends FxTargetAccumulationRegion>) o.getAccumulationRegion()).size(), 1, 2), 
				checkCardinality("knockoutLevel", (FxKnockoutLevel) o.getKnockoutLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockoutCount", (FxKnockoutCount) o.getKnockoutCount() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTarget> validate(RosettaPath path, FxTarget o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTarget", ValidationType.CARDINALITY, "FxTarget", path, "", error);
		}
		return success("FxTarget", ValidationType.CARDINALITY, "FxTarget", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTarget o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTarget", ValidationType.CARDINALITY, "FxTarget", path, "", res.getError());
				}
				return success("FxTarget", ValidationType.CARDINALITY, "FxTarget", path, "");
			})
			.collect(toList());
	}

}
