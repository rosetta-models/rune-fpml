package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.FxLinkedNotionalSchedule;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.RelativeDateOffset;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxLinkedNotionalScheduleValidator implements Validator<FxLinkedNotionalSchedule> {

	private List<ComparisonResult> getComparisonResults(FxLinkedNotionalSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("constantNotionalScheduleReference", (NotionalReference) o.getConstantNotionalScheduleReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("initialValue", (BigDecimal) o.getInitialValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("varyingNotionalCurrency", (Currency) o.getVaryingNotionalCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("varyingNotionalFixingDates", (RelativeDateOffset) o.getVaryingNotionalFixingDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxSpotRateSource", (FxSpotRateSource) o.getFxSpotRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("varyingNotionalInterimExchangePaymentDates", (RelativeDateOffset) o.getVaryingNotionalInterimExchangePaymentDates() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxLinkedNotionalSchedule> validate(RosettaPath path, FxLinkedNotionalSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxLinkedNotionalSchedule", ValidationType.CARDINALITY, "FxLinkedNotionalSchedule", path, "", error);
		}
		return success("FxLinkedNotionalSchedule", ValidationType.CARDINALITY, "FxLinkedNotionalSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxLinkedNotionalSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxLinkedNotionalSchedule", ValidationType.CARDINALITY, "FxLinkedNotionalSchedule", path, "", res.getError());
				}
				return success("FxLinkedNotionalSchedule", ValidationType.CARDINALITY, "FxLinkedNotionalSchedule", path, "");
			})
			.collect(toList());
	}

}
