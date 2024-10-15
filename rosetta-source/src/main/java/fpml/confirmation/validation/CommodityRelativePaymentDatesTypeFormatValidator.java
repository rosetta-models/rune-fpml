package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityRelativePaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityRelativePaymentDatesTypeFormatValidator implements Validator<CommodityRelativePaymentDates> {

	private List<ComparisonResult> getComparisonResults(CommodityRelativePaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, CommodityRelativePaymentDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityRelativePaymentDates", ValidationType.TYPE_FORMAT, "CommodityRelativePaymentDates", path, "", error);
		}
		return success("CommodityRelativePaymentDates", ValidationType.TYPE_FORMAT, "CommodityRelativePaymentDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativePaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityRelativePaymentDates", ValidationType.TYPE_FORMAT, "CommodityRelativePaymentDates", path, "", res.getError());
				}
				return success("CommodityRelativePaymentDates", ValidationType.TYPE_FORMAT, "CommodityRelativePaymentDates", path, "");
			})
			.collect(toList());
	}

}
