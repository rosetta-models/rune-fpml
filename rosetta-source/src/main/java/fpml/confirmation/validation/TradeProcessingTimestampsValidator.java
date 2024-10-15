package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeProcessingTimestamps;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeProcessingTimestampsValidator implements Validator<TradeProcessingTimestamps> {

	private List<ComparisonResult> getComparisonResults(TradeProcessingTimestamps o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("orderEntered", (ZonedDateTime) o.getOrderEntered() != null ? 1 : 0, 0, 1), 
				checkCardinality("orderSubmitted", (ZonedDateTime) o.getOrderSubmitted() != null ? 1 : 0, 0, 1), 
				checkCardinality("publiclyReported", (ZonedDateTime) o.getPubliclyReported() != null ? 1 : 0, 0, 1), 
				checkCardinality("publicReportAccepted", (ZonedDateTime) o.getPublicReportAccepted() != null ? 1 : 0, 0, 1), 
				checkCardinality("publicReportUpdated", (ZonedDateTime) o.getPublicReportUpdated() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonpubliclyReported", (ZonedDateTime) o.getNonpubliclyReported() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonpublicReportAccepted", (ZonedDateTime) o.getNonpublicReportAccepted() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonpublicReportUpdated", (ZonedDateTime) o.getNonpublicReportUpdated() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittedForConfirmation", (ZonedDateTime) o.getSubmittedForConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("updatedForConfirmation", (ZonedDateTime) o.getUpdatedForConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmed", (ZonedDateTime) o.getConfirmed() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittedForClearing", (ZonedDateTime) o.getSubmittedForClearing() != null ? 1 : 0, 0, 1), 
				checkCardinality("updatedForClearing", (ZonedDateTime) o.getUpdatedForClearing() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleared", (ZonedDateTime) o.getCleared() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationsSubmitted", (ZonedDateTime) o.getAllocationsSubmitted() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationsUpdated", (ZonedDateTime) o.getAllocationsUpdated() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationsCompleted", (ZonedDateTime) o.getAllocationsCompleted() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeProcessingTimestamps> validate(RosettaPath path, TradeProcessingTimestamps o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeProcessingTimestamps", ValidationType.CARDINALITY, "TradeProcessingTimestamps", path, "", error);
		}
		return success("TradeProcessingTimestamps", ValidationType.CARDINALITY, "TradeProcessingTimestamps", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeProcessingTimestamps o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeProcessingTimestamps", ValidationType.CARDINALITY, "TradeProcessingTimestamps", path, "", res.getError());
				}
				return success("TradeProcessingTimestamps", ValidationType.CARDINALITY, "TradeProcessingTimestamps", path, "");
			})
			.collect(toList());
	}

}
