package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeOrInfoModel;
import fpml.confirmation.TradeOrInfoModelSequence;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeOrInfoModelValidator implements Validator<TradeOrInfoModel> {

	private List<ComparisonResult> getComparisonResults(TradeOrInfoModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeOrInfoModelSequence", (TradeOrInfoModelSequence) o.getTradeOrInfoModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeReferenceInformationModel", (TradeReferenceInformationModel) o.getTradeReferenceInformationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeOrInfoModel> validate(RosettaPath path, TradeOrInfoModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeOrInfoModel", ValidationType.CARDINALITY, "TradeOrInfoModel", path, "", error);
		}
		return success("TradeOrInfoModel", ValidationType.CARDINALITY, "TradeOrInfoModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeOrInfoModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeOrInfoModel", ValidationType.CARDINALITY, "TradeOrInfoModel", path, "", res.getError());
				}
				return success("TradeOrInfoModel", ValidationType.CARDINALITY, "TradeOrInfoModel", path, "");
			})
			.collect(toList());
	}

}
