package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.PackageInformation;
import fpml.confirmation.TradeProcessingTimestamps;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PackageInformationValidator implements Validator<PackageInformation> {

	private List<ComparisonResult> getComparisonResults(PackageInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timestamps", (TradeProcessingTimestamps) o.getTimestamps() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToAllocate", (Boolean) o.getIntentToAllocate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToClear", (Boolean) o.getIntentToClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatus", (ClearingStatusValue) o.getClearingStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PackageInformation> validate(RosettaPath path, PackageInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PackageInformation", ValidationType.CARDINALITY, "PackageInformation", path, "", error);
		}
		return success("PackageInformation", ValidationType.CARDINALITY, "PackageInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PackageInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PackageInformation", ValidationType.CARDINALITY, "PackageInformation", path, "", res.getError());
				}
				return success("PackageInformation", ValidationType.CARDINALITY, "PackageInformation", path, "");
			})
			.collect(toList());
	}

}
