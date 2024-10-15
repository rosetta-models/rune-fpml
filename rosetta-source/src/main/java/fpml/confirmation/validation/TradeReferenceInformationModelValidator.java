package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TradeReferenceInformation;
import fpml.confirmation.TradeReferenceInformationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeReferenceInformationModelValidator implements Validator<TradeReferenceInformationModel> {

	private List<ComparisonResult> getComparisonResults(TradeReferenceInformationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeReferenceInformation", (TradeReferenceInformation) o.getTradeReferenceInformation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeReferenceInformationModel> validate(RosettaPath path, TradeReferenceInformationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeReferenceInformationModel", ValidationType.CARDINALITY, "TradeReferenceInformationModel", path, "", error);
		}
		return success("TradeReferenceInformationModel", ValidationType.CARDINALITY, "TradeReferenceInformationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReferenceInformationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReferenceInformationModel", ValidationType.CARDINALITY, "TradeReferenceInformationModel", path, "", res.getError());
				}
				return success("TradeReferenceInformationModel", ValidationType.CARDINALITY, "TradeReferenceInformationModel", path, "");
			})
			.collect(toList());
	}

}
