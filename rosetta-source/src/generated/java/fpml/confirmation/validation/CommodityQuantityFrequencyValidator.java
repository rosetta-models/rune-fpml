package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityQuantityFrequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityQuantityFrequencyValidator implements Validator<CommodityQuantityFrequency> {

	private List<ComparisonResult> getComparisonResults(CommodityQuantityFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityFrequencyScheme", (String) o.getQuantityFrequencyScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityQuantityFrequency> validate(RosettaPath path, CommodityQuantityFrequency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityQuantityFrequency", ValidationType.CARDINALITY, "CommodityQuantityFrequency", path, "", error);
		}
		return success("CommodityQuantityFrequency", ValidationType.CARDINALITY, "CommodityQuantityFrequency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityQuantityFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityQuantityFrequency", ValidationType.CARDINALITY, "CommodityQuantityFrequency", path, "", res.getError());
				}
				return success("CommodityQuantityFrequency", ValidationType.CARDINALITY, "CommodityQuantityFrequency", path, "");
			})
			.collect(toList());
	}

}
