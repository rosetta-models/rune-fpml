package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.QuotationCharacteristicsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MultiDimensionalPricingDataValidator implements Validator<MultiDimensionalPricingData> {

	private List<ComparisonResult> getComparisonResults(MultiDimensionalPricingData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotationCharacteristicsModel", (QuotationCharacteristicsModel) o.getQuotationCharacteristicsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("point", (List<? extends PricingStructurePoint>) o.getPoint() == null ? 0 : ((List<? extends PricingStructurePoint>) o.getPoint()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<MultiDimensionalPricingData> validate(RosettaPath path, MultiDimensionalPricingData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MultiDimensionalPricingData", ValidationType.CARDINALITY, "MultiDimensionalPricingData", path, "", error);
		}
		return success("MultiDimensionalPricingData", ValidationType.CARDINALITY, "MultiDimensionalPricingData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiDimensionalPricingData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultiDimensionalPricingData", ValidationType.CARDINALITY, "MultiDimensionalPricingData", path, "", res.getError());
				}
				return success("MultiDimensionalPricingData", ValidationType.CARDINALITY, "MultiDimensionalPricingData", path, "");
			})
			.collect(toList());
	}

}
