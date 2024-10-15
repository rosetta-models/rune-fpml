package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyNoticePeriodValidator implements Validator<PartyNoticePeriod> {

	private List<ComparisonResult> getComparisonResults(PartyNoticePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("noticePeriod", (AdjustableOffset) o.getNoticePeriod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PartyNoticePeriod> validate(RosettaPath path, PartyNoticePeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyNoticePeriod", ValidationType.CARDINALITY, "PartyNoticePeriod", path, "", error);
		}
		return success("PartyNoticePeriod", ValidationType.CARDINALITY, "PartyNoticePeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyNoticePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyNoticePeriod", ValidationType.CARDINALITY, "PartyNoticePeriod", path, "", res.getError());
				}
				return success("PartyNoticePeriod", ValidationType.CARDINALITY, "PartyNoticePeriod", path, "");
			})
			.collect(toList());
	}

}
