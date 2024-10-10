package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.CreditEventNoticeType;
import fpml.confirmation.NotifyingParty;
import fpml.confirmation.PubliclyAvailableInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeTypeValidator implements Validator<CreditEventNoticeType> {

	private List<ComparisonResult> getComparisonResults(CreditEventNoticeType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notifyingParty", (NotifyingParty) o.getNotifyingParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenter", (BusinessCenter) o.getBusinessCenter() != null ? 1 : 0, 0, 1), 
				checkCardinality("publiclyAvailableInformation", (PubliclyAvailableInformation) o.getPubliclyAvailableInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditEventNoticeType> validate(RosettaPath path, CreditEventNoticeType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditEventNoticeType", ValidationType.CARDINALITY, "CreditEventNoticeType", path, "", error);
		}
		return success("CreditEventNoticeType", ValidationType.CARDINALITY, "CreditEventNoticeType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventNoticeType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventNoticeType", ValidationType.CARDINALITY, "CreditEventNoticeType", path, "", res.getError());
				}
				return success("CreditEventNoticeType", ValidationType.CARDINALITY, "CreditEventNoticeType", path, "");
			})
			.collect(toList());
	}

}
