package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence1;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliverySequence1Validator implements Validator<ElectricityDeliverySequence1> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliverySequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryZone", (CommodityDeliveryPoint) o.getDeliveryZone() != null ? 1 : 0, 1, 1), 
				checkCardinality("electingPartyReference", (PartyReference) o.getElectingPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityDeliverySequence1> validate(RosettaPath path, ElectricityDeliverySequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDeliverySequence1", ValidationType.CARDINALITY, "ElectricityDeliverySequence1", path, "", error);
		}
		return success("ElectricityDeliverySequence1", ValidationType.CARDINALITY, "ElectricityDeliverySequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliverySequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliverySequence1", ValidationType.CARDINALITY, "ElectricityDeliverySequence1", path, "", res.getError());
				}
				return success("ElectricityDeliverySequence1", ValidationType.CARDINALITY, "ElectricityDeliverySequence1", path, "");
			})
			.collect(toList());
	}

}
