package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicablePurpose;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.PersonReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApplicableCommunicationDetailsValidator implements Validator<ApplicableCommunicationDetails> {

	private List<ComparisonResult> getComparisonResults(ApplicableCommunicationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (AssociationToAssetIdentifier) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableAssets", (ApplicableAssets) o.getApplicableAssets() != null ? 1 : 0, 0, 1), 
				checkCardinality("purpose", (ApplicablePurpose) o.getPurpose() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessUnitReference", (BusinessUnitReference) o.getBusinessUnitReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("personReference", (PersonReference) o.getPersonReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, ApplicableCommunicationDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ApplicableCommunicationDetails", ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "", error);
		}
		return success("ApplicableCommunicationDetails", ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableCommunicationDetails", ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "", res.getError());
				}
				return success("ApplicableCommunicationDetails", ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "");
			})
			.collect(toList());
	}

}
