package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Beneficiary;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RoutingIdentificationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BeneficiaryValidator implements Validator<Beneficiary> {

	private List<ComparisonResult> getComparisonResults(Beneficiary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingIdentificationModel", (RoutingIdentificationModel) o.getRoutingIdentificationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("beneficiaryPartyReference", (PartyReference) o.getBeneficiaryPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Beneficiary> validate(RosettaPath path, Beneficiary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Beneficiary", ValidationType.CARDINALITY, "Beneficiary", path, "", error);
		}
		return success("Beneficiary", ValidationType.CARDINALITY, "Beneficiary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Beneficiary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Beneficiary", ValidationType.CARDINALITY, "Beneficiary", path, "", res.getError());
				}
				return success("Beneficiary", ValidationType.CARDINALITY, "Beneficiary", path, "");
			})
			.collect(toList());
	}

}
