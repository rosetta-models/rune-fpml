package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcAccrual;
import fpml.confirmation.LcPurpose;
import fpml.confirmation.LcType;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditValidator implements Validator<LetterOfCredit> {

	private List<ComparisonResult> getComparisonResults(LetterOfCredit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends FacilityContractIdentifier>) o.getIdentifier() == null ? 0 : ((List<? extends FacilityContractIdentifier>) o.getIdentifier()).size(), 1, 0), 
				checkCardinality("type", (LcType) o.getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("letterOfCreditRolesModel", (LetterOfCreditRolesModel) o.getLetterOfCreditRolesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalExpiryDate", (Date) o.getFinalExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcAccrual", (LcAccrual) o.getLcAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("purpose", (LcPurpose) o.getPurpose() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditFeaturesModel", (LetterOfCreditFeaturesModel) o.getLetterOfCreditFeaturesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityFxRate", (FxTerms) o.getFacilityFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LetterOfCredit> validate(RosettaPath path, LetterOfCredit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LetterOfCredit", ValidationType.CARDINALITY, "LetterOfCredit", path, "", error);
		}
		return success("LetterOfCredit", ValidationType.CARDINALITY, "LetterOfCredit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCredit", ValidationType.CARDINALITY, "LetterOfCredit", path, "", res.getError());
				}
				return success("LetterOfCredit", ValidationType.CARDINALITY, "LetterOfCredit", path, "");
			})
			.collect(toList());
	}

}
