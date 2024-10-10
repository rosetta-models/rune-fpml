package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.PartyId;
import fpml.confirmation.PartyInformationModel;
import fpml.confirmation.PartyModel;
import fpml.confirmation.PartyName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyModelValidator implements Validator<PartyModel> {

	private List<ComparisonResult> getComparisonResults(PartyModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyId", (List<? extends PartyId>) o.getPartyId() == null ? 0 : ((List<? extends PartyId>) o.getPartyId()).size(), 1, 0), 
				checkCardinality("partyName", (PartyName) o.getPartyName() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyInformationModel", (PartyInformationModel) o.getPartyInformationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("contactInfo", (ContactInformation) o.getContactInfo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyModel> validate(RosettaPath path, PartyModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyModel", ValidationType.CARDINALITY, "PartyModel", path, "", error);
		}
		return success("PartyModel", ValidationType.CARDINALITY, "PartyModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyModel", ValidationType.CARDINALITY, "PartyModel", path, "", res.getError());
				}
				return success("PartyModel", ValidationType.CARDINALITY, "PartyModel", path, "");
			})
			.collect(toList());
	}

}
