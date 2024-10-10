package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerTradeId;
import fpml.confirmation.IssuerTradeIdModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IssuerTradeIdValidator implements Validator<IssuerTradeId> {

	private List<ComparisonResult> getComparisonResults(IssuerTradeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerTradeIdModel", (IssuerTradeIdModel) o.getIssuerTradeIdModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<IssuerTradeId> validate(RosettaPath path, IssuerTradeId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerTradeId", ValidationType.CARDINALITY, "IssuerTradeId", path, "", error);
		}
		return success("IssuerTradeId", ValidationType.CARDINALITY, "IssuerTradeId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerTradeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerTradeId", ValidationType.CARDINALITY, "IssuerTradeId", path, "", res.getError());
				}
				return success("IssuerTradeId", ValidationType.CARDINALITY, "IssuerTradeId", path, "");
			})
			.collect(toList());
	}

}
