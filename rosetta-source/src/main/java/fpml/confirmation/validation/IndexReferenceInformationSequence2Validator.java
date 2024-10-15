package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.IndexReferenceInformationSequence2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndexReferenceInformationSequence2Validator implements Validator<IndexReferenceInformationSequence2> {

	private List<ComparisonResult> getComparisonResults(IndexReferenceInformationSequence2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
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
			return failure("IndexReferenceInformationSequence2", ValidationType.CARDINALITY, "IndexReferenceInformationSequence2", path, "", error);
		}
		return success("IndexReferenceInformationSequence2", ValidationType.CARDINALITY, "IndexReferenceInformationSequence2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexReferenceInformationSequence2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexReferenceInformationSequence2", ValidationType.CARDINALITY, "IndexReferenceInformationSequence2", path, "", res.getError());
				}
				return success("IndexReferenceInformationSequence2", ValidationType.CARDINALITY, "IndexReferenceInformationSequence2", path, "");
			})
			.collect(toList());
	}

}
