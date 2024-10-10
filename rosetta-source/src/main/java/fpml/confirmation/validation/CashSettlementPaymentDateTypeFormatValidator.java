package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashSettlementPaymentDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashSettlementPaymentDateTypeFormatValidator implements Validator<CashSettlementPaymentDate> {

	private List<ComparisonResult> getComparisonResults(CashSettlementPaymentDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CashSettlementPaymentDate> validate(RosettaPath path, CashSettlementPaymentDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashSettlementPaymentDate", ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "", error);
		}
		return success("CashSettlementPaymentDate", ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementPaymentDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlementPaymentDate", ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "", res.getError());
				}
				return success("CashSettlementPaymentDate", ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "");
			})
			.collect(toList());
	}

}
