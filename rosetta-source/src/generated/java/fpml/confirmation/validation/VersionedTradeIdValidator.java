package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeId;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionedTradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VersionedTradeIdValidator implements Validator<VersionedTradeId> {

	private List<ComparisonResult> getComparisonResults(VersionedTradeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 1, 1), 
				checkCardinality("versionHistoryModel", (VersionHistoryModel) o.getVersionHistoryModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<VersionedTradeId> validate(RosettaPath path, VersionedTradeId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VersionedTradeId", ValidationType.CARDINALITY, "VersionedTradeId", path, "", error);
		}
		return success("VersionedTradeId", ValidationType.CARDINALITY, "VersionedTradeId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedTradeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedTradeId", ValidationType.CARDINALITY, "VersionedTradeId", path, "", res.getError());
				}
				return success("VersionedTradeId", ValidationType.CARDINALITY, "VersionedTradeId", path, "");
			})
			.collect(toList());
	}

}
