package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPostponement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPostponementTypeFormatValidator implements Validator<SettlementPostponement> {

	private List<ComparisonResult> getComparisonResults(SettlementPostponement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("maximumNumberOfDays", o.getMaximumNumberOfDays(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<SettlementPostponement> validate(RosettaPath path, SettlementPostponement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPostponement", ValidationType.TYPE_FORMAT, "SettlementPostponement", path, "", error);
		}
		return success("SettlementPostponement", ValidationType.TYPE_FORMAT, "SettlementPostponement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPostponement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPostponement", ValidationType.TYPE_FORMAT, "SettlementPostponement", path, "", res.getError());
				}
				return success("SettlementPostponement", ValidationType.TYPE_FORMAT, "SettlementPostponement", path, "");
			})
			.collect(toList());
	}

}
