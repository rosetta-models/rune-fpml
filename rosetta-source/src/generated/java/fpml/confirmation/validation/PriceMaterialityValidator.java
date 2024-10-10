package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PriceMateriality;
import fpml.confirmation.PrioritizedRateSourceModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceMaterialityValidator implements Validator<PriceMateriality> {

	private List<ComparisonResult> getComparisonResults(PriceMateriality o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("prioritizedRateSourceModel", (PrioritizedRateSourceModel) o.getPrioritizedRateSourceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("percentage", (BigDecimal) o.getPercentage() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PriceMateriality> validate(RosettaPath path, PriceMateriality o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PriceMateriality", ValidationType.CARDINALITY, "PriceMateriality", path, "", error);
		}
		return success("PriceMateriality", ValidationType.CARDINALITY, "PriceMateriality", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceMateriality o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceMateriality", ValidationType.CARDINALITY, "PriceMateriality", path, "", res.getError());
				}
				return success("PriceMateriality", ValidationType.CARDINALITY, "PriceMateriality", path, "");
			})
			.collect(toList());
	}

}
