package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.TradeMaturity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeMaturityValidator implements Validator<TradeMaturity> {

	private List<ComparisonResult> getComparisonResults(TradeMaturity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getTradeIdentifier() == null ? 0 : ((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()).size(), 1, 0), 
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeMaturity> validate(RosettaPath path, TradeMaturity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeMaturity", ValidationType.CARDINALITY, "TradeMaturity", path, "", error);
		}
		return success("TradeMaturity", ValidationType.CARDINALITY, "TradeMaturity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeMaturity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeMaturity", ValidationType.CARDINALITY, "TradeMaturity", path, "", res.getError());
				}
				return success("TradeMaturity", ValidationType.CARDINALITY, "TradeMaturity", path, "");
			})
			.collect(toList());
	}

}
