package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexReferenceInformationSequence2;
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

public class IndexReferenceInformationSequence2TypeFormatValidator implements Validator<IndexReferenceInformationSequence2> {

	private List<ComparisonResult> getComparisonResults(IndexReferenceInformationSequence2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("indexFactor", o.getIndexFactor(), empty(), empty(), of(new BigDecimal("0")), of(new BigDecimal("1")))
			);
	}

	@Override
	public ValidationResult<IndexReferenceInformationSequence2> validate(RosettaPath path, IndexReferenceInformationSequence2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexReferenceInformationSequence2", ValidationType.TYPE_FORMAT, "IndexReferenceInformationSequence2", path, "", error);
		}
		return success("IndexReferenceInformationSequence2", ValidationType.TYPE_FORMAT, "IndexReferenceInformationSequence2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexReferenceInformationSequence2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexReferenceInformationSequence2", ValidationType.TYPE_FORMAT, "IndexReferenceInformationSequence2", path, "", res.getError());
				}
				return success("IndexReferenceInformationSequence2", ValidationType.TYPE_FORMAT, "IndexReferenceInformationSequence2", path, "");
			})
			.collect(toList());
	}

}
