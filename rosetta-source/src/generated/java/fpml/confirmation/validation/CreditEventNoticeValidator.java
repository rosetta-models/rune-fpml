package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEventNotice;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeValidator implements Validator<CreditEventNotice> {

	private List<ComparisonResult> getComparisonResults(CreditEventNotice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("affectedTransactions", (AffectedTransactions) o.getAffectedTransactions() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEvent", (CreditEvent) o.getCreditEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("notifyingPartyReference", (PartyReference) o.getNotifyingPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("notifiedPartyReference", (PartyReference) o.getNotifiedPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEventNoticeDate", (Date) o.getCreditEventNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEventDate", (Date) o.getCreditEventDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CreditEventNotice> validate(RosettaPath path, CreditEventNotice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditEventNotice", ValidationType.CARDINALITY, "CreditEventNotice", path, "", error);
		}
		return success("CreditEventNotice", ValidationType.CARDINALITY, "CreditEventNotice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventNotice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventNotice", ValidationType.CARDINALITY, "CreditEventNotice", path, "", res.getError());
				}
				return success("CreditEventNotice", ValidationType.CARDINALITY, "CreditEventNotice", path, "");
			})
			.collect(toList());
	}

}
