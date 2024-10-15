package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AccruingFeeChangeNotification;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityPosition;
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

public class AccruingFeeChangeNotificationValidator implements Validator<AccruingFeeChangeNotification> {

	private List<ComparisonResult> getComparisonResults(AccruingFeeChangeNotification o) {
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
				checkCardinality("facilityPosition", (FacilityPosition) o.getFacilityPosition() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruingFeeChangeGroup", (AbstractFacilityEvent) o.getAccruingFeeChangeGroup() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityDetailsModel", (FacilityDetailsModel) o.getFacilityDetailsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<AccruingFeeChangeNotification> validate(RosettaPath path, AccruingFeeChangeNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccruingFeeChangeNotification", ValidationType.CARDINALITY, "AccruingFeeChangeNotification", path, "", error);
		}
		return success("AccruingFeeChangeNotification", ValidationType.CARDINALITY, "AccruingFeeChangeNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccruingFeeChangeNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccruingFeeChangeNotification", ValidationType.CARDINALITY, "AccruingFeeChangeNotification", path, "", res.getError());
				}
				return success("AccruingFeeChangeNotification", ValidationType.CARDINALITY, "AccruingFeeChangeNotification", path, "");
			})
			.collect(toList());
	}

}
