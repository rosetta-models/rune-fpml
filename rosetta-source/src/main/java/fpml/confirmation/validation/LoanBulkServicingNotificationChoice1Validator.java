package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationChoice1Validator implements Validator<LoanBulkServicingNotificationChoice1> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotificationChoice1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityDetailsModel", (FacilityDetailsModel) o.getFacilityDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanBulkServicingNotificationChoiceChoice", (LoanBulkServicingNotificationChoiceChoice) o.getLoanBulkServicingNotificationChoiceChoice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanBulkServicingNotificationChoice1> validate(RosettaPath path, LoanBulkServicingNotificationChoice1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanBulkServicingNotificationChoice1", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice1", path, "", error);
		}
		return success("LoanBulkServicingNotificationChoice1", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationChoice1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotificationChoice1", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice1", path, "", res.getError());
				}
				return success("LoanBulkServicingNotificationChoice1", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice1", path, "");
			})
			.collect(toList());
	}

}
