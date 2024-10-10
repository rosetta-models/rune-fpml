package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityDeliveryFirm;
import fpml.confirmation.ElectricityDeliverySystemFirm;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.ElectricityDeliveryUnitFirm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryTypeValidator implements Validator<ElectricityDeliveryType> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliveryType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("firm", (ElectricityDeliveryFirm) o.getFirm() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonFirm", (Boolean) o.getNonFirm() != null ? 1 : 0, 0, 1), 
				checkCardinality("systemFirm", (ElectricityDeliverySystemFirm) o.getSystemFirm() != null ? 1 : 0, 0, 1), 
				checkCardinality("unitFirm", (ElectricityDeliveryUnitFirm) o.getUnitFirm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityDeliveryType> validate(RosettaPath path, ElectricityDeliveryType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDeliveryType", ValidationType.CARDINALITY, "ElectricityDeliveryType", path, "", error);
		}
		return success("ElectricityDeliveryType", ValidationType.CARDINALITY, "ElectricityDeliveryType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliveryType", ValidationType.CARDINALITY, "ElectricityDeliveryType", path, "", res.getError());
				}
				return success("ElectricityDeliveryType", ValidationType.CARDINALITY, "ElectricityDeliveryType", path, "");
			})
			.collect(toList());
	}

}
