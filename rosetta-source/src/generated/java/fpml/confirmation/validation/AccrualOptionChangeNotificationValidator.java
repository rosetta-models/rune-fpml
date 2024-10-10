package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualOptionChangeNotification;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import fpml.confirmation.AccruingPikOptionChange;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualOptionChangeNotificationValidator implements Validator<AccrualOptionChangeNotification> {

	private List<ComparisonResult> getComparisonResults(AccrualOptionChangeNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticeDate", (Date) o.getNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("isGlobalOnly", (Boolean) o.getIsGlobalOnly() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrualOptionChangeNotificationSequence0", (AccrualOptionChangeNotificationSequence0) o.getAccrualOptionChangeNotificationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruingPikOptionChange", (AccruingPikOptionChange) o.getAccruingPikOptionChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualOptionChangeNotificationSequence1", (AccrualOptionChangeNotificationSequence1) o.getAccrualOptionChangeNotificationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityDetailsModel", (FacilityDetailsModel) o.getFacilityDetailsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<AccrualOptionChangeNotification> validate(RosettaPath path, AccrualOptionChangeNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualOptionChangeNotification", ValidationType.CARDINALITY, "AccrualOptionChangeNotification", path, "", error);
		}
		return success("AccrualOptionChangeNotification", ValidationType.CARDINALITY, "AccrualOptionChangeNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualOptionChangeNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualOptionChangeNotification", ValidationType.CARDINALITY, "AccrualOptionChangeNotification", path, "", res.getError());
				}
				return success("AccrualOptionChangeNotification", ValidationType.CARDINALITY, "AccrualOptionChangeNotification", path, "");
			})
			.collect(toList());
	}

}
