package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ImplementationSpecification;
import fpml.confirmation.MessageAddress;
import fpml.confirmation.MessageHeaderModel;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MessageHeaderModelValidator implements Validator<MessageHeaderModel> {

	private List<ComparisonResult> getComparisonResults(MessageHeaderModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sentBy", (MessageAddress) o.getSentBy() != null ? 1 : 0, 1, 1), 
				checkCardinality("creationTimestamp", (ZonedDateTime) o.getCreationTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryTimestamp", (ZonedDateTime) o.getExpiryTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("implementationSpecification", (ImplementationSpecification) o.getImplementationSpecification() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MessageHeaderModel> validate(RosettaPath path, MessageHeaderModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MessageHeaderModel", ValidationType.CARDINALITY, "MessageHeaderModel", path, "", error);
		}
		return success("MessageHeaderModel", ValidationType.CARDINALITY, "MessageHeaderModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MessageHeaderModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MessageHeaderModel", ValidationType.CARDINALITY, "MessageHeaderModel", path, "", res.getError());
				}
				return success("MessageHeaderModel", ValidationType.CARDINALITY, "MessageHeaderModel", path, "");
			})
			.collect(toList());
	}

}
