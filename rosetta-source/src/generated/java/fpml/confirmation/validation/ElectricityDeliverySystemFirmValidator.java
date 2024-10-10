package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySystemFirm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliverySystemFirmValidator implements Validator<ElectricityDeliverySystemFirm> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliverySystemFirm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("system", (CommodityDeliveryPoint) o.getSystem() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityDeliverySystemFirm> validate(RosettaPath path, ElectricityDeliverySystemFirm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDeliverySystemFirm", ValidationType.CARDINALITY, "ElectricityDeliverySystemFirm", path, "", error);
		}
		return success("ElectricityDeliverySystemFirm", ValidationType.CARDINALITY, "ElectricityDeliverySystemFirm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliverySystemFirm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliverySystemFirm", ValidationType.CARDINALITY, "ElectricityDeliverySystemFirm", path, "", res.getError());
				}
				return success("ElectricityDeliverySystemFirm", ValidationType.CARDINALITY, "ElectricityDeliverySystemFirm", path, "");
			})
			.collect(toList());
	}

}
