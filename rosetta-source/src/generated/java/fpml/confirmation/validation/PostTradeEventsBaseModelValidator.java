package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.Withdrawal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PostTradeEventsBaseModelValidator implements Validator<PostTradeEventsBaseModel> {

	private List<ComparisonResult> getComparisonResults(PostTradeEventsBaseModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amendment", (TradeAmendmentContent) o.getAmendment() != null ? 1 : 0, 0, 1), 
				checkCardinality("increase", (TradeNotionalChange) o.getIncrease() != null ? 1 : 0, 0, 1), 
				checkCardinality("postTradeEventsBaseModelSequence", (PostTradeEventsBaseModelSequence) o.getPostTradeEventsBaseModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("novation", (TradeNovationContent) o.getNovation() != null ? 1 : 0, 0, 1), 
				checkCardinality("withdrawal", (Withdrawal) o.getWithdrawal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PostTradeEventsBaseModel> validate(RosettaPath path, PostTradeEventsBaseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PostTradeEventsBaseModel", ValidationType.CARDINALITY, "PostTradeEventsBaseModel", path, "", error);
		}
		return success("PostTradeEventsBaseModel", ValidationType.CARDINALITY, "PostTradeEventsBaseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostTradeEventsBaseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostTradeEventsBaseModel", ValidationType.CARDINALITY, "PostTradeEventsBaseModel", path, "", res.getError());
				}
				return success("PostTradeEventsBaseModel", ValidationType.CARDINALITY, "PostTradeEventsBaseModel", path, "");
			})
			.collect(toList());
	}

}
