package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingLevel;
import fpml.confirmation.TradeSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeSummaryValidator implements Validator<TradeSummary> {

	private List<ComparisonResult> getComparisonResults(TradeSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isPackageTrade", (Boolean) o.getIsPackageTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("isPrimeBrokerTrade", (Boolean) o.getIsPrimeBrokerTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingLevel", (ReportingLevel) o.getReportingLevel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeSummary> validate(RosettaPath path, TradeSummary o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeSummary", ValidationType.CARDINALITY, "TradeSummary", path, "", error);
		}
		return success("TradeSummary", ValidationType.CARDINALITY, "TradeSummary", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeSummary", ValidationType.CARDINALITY, "TradeSummary", path, "", res.getError());
				}
				return success("TradeSummary", ValidationType.CARDINALITY, "TradeSummary", path, "");
			})
			.collect(toList());
	}

}
