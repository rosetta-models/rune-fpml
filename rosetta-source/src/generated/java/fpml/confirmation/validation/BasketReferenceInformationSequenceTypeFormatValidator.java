package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketReferenceInformationSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketReferenceInformationSequenceTypeFormatValidator implements Validator<BasketReferenceInformationSequence> {

	private List<ComparisonResult> getComparisonResults(BasketReferenceInformationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("nthToDefault", o.getNthToDefault(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("mthToDefault", o.getMthToDefault(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<BasketReferenceInformationSequence> validate(RosettaPath path, BasketReferenceInformationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketReferenceInformationSequence", ValidationType.TYPE_FORMAT, "BasketReferenceInformationSequence", path, "", error);
		}
		return success("BasketReferenceInformationSequence", ValidationType.TYPE_FORMAT, "BasketReferenceInformationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketReferenceInformationSequence", ValidationType.TYPE_FORMAT, "BasketReferenceInformationSequence", path, "", res.getError());
				}
				return success("BasketReferenceInformationSequence", ValidationType.TYPE_FORMAT, "BasketReferenceInformationSequence", path, "");
			})
			.collect(toList());
	}

}
