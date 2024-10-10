package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Clearing;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.ClearingResultsModelSequence;
import fpml.confirmation.DeClear;
import fpml.confirmation.TradingEventsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingResultsModelValidator implements Validator<ClearingResultsModel> {

	private List<ComparisonResult> getComparisonResults(ClearingResultsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradingEventsModel", (TradingEventsModel) o.getTradingEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingResultsModelSequence", (ClearingResultsModelSequence) o.getClearingResultsModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("deClear", (DeClear) o.getDeClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearing", (Clearing) o.getClearing() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ClearingResultsModel> validate(RosettaPath path, ClearingResultsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingResultsModel", ValidationType.CARDINALITY, "ClearingResultsModel", path, "", error);
		}
		return success("ClearingResultsModel", ValidationType.CARDINALITY, "ClearingResultsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingResultsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingResultsModel", ValidationType.CARDINALITY, "ClearingResultsModel", path, "", res.getError());
				}
				return success("ClearingResultsModel", ValidationType.CARDINALITY, "ClearingResultsModel", path, "");
			})
			.collect(toList());
	}

}
