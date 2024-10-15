package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.FxDisruption;
import fpml.confirmation.FxDisruptionProvisions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDisruptionValidator implements Validator<FxDisruption> {

	private List<ComparisonResult> getComparisonResults(FxDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("baseCurrency", (Currency) o.getBaseCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("provisions", (List<? extends FxDisruptionProvisions>) o.getProvisions() == null ? 0 : ((List<? extends FxDisruptionProvisions>) o.getProvisions()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxDisruption> validate(RosettaPath path, FxDisruption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDisruption", ValidationType.CARDINALITY, "FxDisruption", path, "", error);
		}
		return success("FxDisruption", ValidationType.CARDINALITY, "FxDisruption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruption", ValidationType.CARDINALITY, "FxDisruption", path, "", res.getError());
				}
				return success("FxDisruption", ValidationType.CARDINALITY, "FxDisruption", path, "");
			})
			.collect(toList());
	}

}
