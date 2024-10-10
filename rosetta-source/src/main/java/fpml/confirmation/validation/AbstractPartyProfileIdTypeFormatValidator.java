package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractPartyProfileId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractPartyProfileIdTypeFormatValidator implements Validator<AbstractPartyProfileId> {

	private List<ComparisonResult> getComparisonResults(AbstractPartyProfileId o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AbstractPartyProfileId> validate(RosettaPath path, AbstractPartyProfileId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractPartyProfileId", ValidationType.TYPE_FORMAT, "AbstractPartyProfileId", path, "", error);
		}
		return success("AbstractPartyProfileId", ValidationType.TYPE_FORMAT, "AbstractPartyProfileId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractPartyProfileId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractPartyProfileId", ValidationType.TYPE_FORMAT, "AbstractPartyProfileId", path, "", res.getError());
				}
				return success("AbstractPartyProfileId", ValidationType.TYPE_FORMAT, "AbstractPartyProfileId", path, "");
			})
			.collect(toList());
	}

}
