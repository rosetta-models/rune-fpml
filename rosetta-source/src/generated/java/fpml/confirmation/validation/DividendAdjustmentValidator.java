package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendAdjustment;
import fpml.confirmation.DividendPeriodDividend;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendAdjustmentValidator implements Validator<DividendAdjustment> {

	private List<ComparisonResult> getComparisonResults(DividendAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPeriod", (List<? extends DividendPeriodDividend>) o.getDividendPeriod() == null ? 0 : ((List<? extends DividendPeriodDividend>) o.getDividendPeriod()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<DividendAdjustment> validate(RosettaPath path, DividendAdjustment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendAdjustment", ValidationType.CARDINALITY, "DividendAdjustment", path, "", error);
		}
		return success("DividendAdjustment", ValidationType.CARDINALITY, "DividendAdjustment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendAdjustment", ValidationType.CARDINALITY, "DividendAdjustment", path, "", res.getError());
				}
				return success("DividendAdjustment", ValidationType.CARDINALITY, "DividendAdjustment", path, "");
			})
			.collect(toList());
	}

}
