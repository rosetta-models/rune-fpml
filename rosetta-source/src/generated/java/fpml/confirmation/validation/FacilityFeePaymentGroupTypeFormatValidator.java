package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityFeePaymentGroup;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityFeePaymentGroupTypeFormatValidator implements Validator<FacilityFeePaymentGroup> {

	private List<ComparisonResult> getComparisonResults(FacilityFeePaymentGroup o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<FacilityFeePaymentGroup> validate(RosettaPath path, FacilityFeePaymentGroup o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityFeePaymentGroup", ValidationType.TYPE_FORMAT, "FacilityFeePaymentGroup", path, "", error);
		}
		return success("FacilityFeePaymentGroup", ValidationType.TYPE_FORMAT, "FacilityFeePaymentGroup", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityFeePaymentGroup o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityFeePaymentGroup", ValidationType.TYPE_FORMAT, "FacilityFeePaymentGroup", path, "", res.getError());
				}
				return success("FacilityFeePaymentGroup", ValidationType.TYPE_FORMAT, "FacilityFeePaymentGroup", path, "");
			})
			.collect(toList());
	}

}
