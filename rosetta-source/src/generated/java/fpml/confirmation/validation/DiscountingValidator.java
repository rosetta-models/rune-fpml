package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DiscountRateModel;
import fpml.confirmation.Discounting;
import fpml.confirmation.DiscountingTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DiscountingValidator implements Validator<Discounting> {

	private List<ComparisonResult> getComparisonResults(Discounting o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("discountingType", (DiscountingTypeEnum) o.getDiscountingType() != null ? 1 : 0, 1, 1), 
				checkCardinality("discountRateModel", (DiscountRateModel) o.getDiscountRateModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Discounting> validate(RosettaPath path, Discounting o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Discounting", ValidationType.CARDINALITY, "Discounting", path, "", error);
		}
		return success("Discounting", ValidationType.CARDINALITY, "Discounting", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Discounting o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Discounting", ValidationType.CARDINALITY, "Discounting", path, "", res.getError());
				}
				return success("Discounting", ValidationType.CARDINALITY, "Discounting", path, "");
			})
			.collect(toList());
	}

}
