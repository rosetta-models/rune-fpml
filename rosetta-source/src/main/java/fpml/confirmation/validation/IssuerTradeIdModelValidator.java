package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerId;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IssuerTradeIdModelValidator implements Validator<IssuerTradeIdModel> {

	private List<ComparisonResult> getComparisonResults(IssuerTradeIdModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<IssuerTradeIdModel> validate(RosettaPath path, IssuerTradeIdModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerTradeIdModel", ValidationType.CARDINALITY, "IssuerTradeIdModel", path, "", error);
		}
		return success("IssuerTradeIdModel", ValidationType.CARDINALITY, "IssuerTradeIdModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerTradeIdModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerTradeIdModel", ValidationType.CARDINALITY, "IssuerTradeIdModel", path, "", res.getError());
				}
				return success("IssuerTradeIdModel", ValidationType.CARDINALITY, "IssuerTradeIdModel", path, "");
			})
			.collect(toList());
	}

}
