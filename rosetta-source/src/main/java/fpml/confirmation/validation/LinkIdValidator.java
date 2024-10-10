package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LinkId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LinkIdValidator implements Validator<LinkId> {

	private List<ComparisonResult> getComparisonResults(LinkId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("linkIdScheme", (String) o.getLinkIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LinkId> validate(RosettaPath path, LinkId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LinkId", ValidationType.CARDINALITY, "LinkId", path, "", error);
		}
		return success("LinkId", ValidationType.CARDINALITY, "LinkId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LinkId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LinkId", ValidationType.CARDINALITY, "LinkId", path, "", res.getError());
				}
				return success("LinkId", ValidationType.CARDINALITY, "LinkId", path, "");
			})
			.collect(toList());
	}

}
