package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliveryUnitFirm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryUnitFirmValidator implements Validator<ElectricityDeliveryUnitFirm> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliveryUnitFirm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("generationAsset", (CommodityDeliveryPoint) o.getGenerationAsset() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityDeliveryUnitFirm> validate(RosettaPath path, ElectricityDeliveryUnitFirm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDeliveryUnitFirm", ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "", error);
		}
		return success("ElectricityDeliveryUnitFirm", ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryUnitFirm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliveryUnitFirm", ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "", res.getError());
				}
				return success("ElectricityDeliveryUnitFirm", ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "");
			})
			.collect(toList());
	}

}
