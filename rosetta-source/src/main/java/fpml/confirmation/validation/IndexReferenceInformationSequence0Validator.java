package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexName;
import fpml.confirmation.IndexReferenceInformationSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndexReferenceInformationSequence0Validator implements Validator<IndexReferenceInformationSequence0> {

	private List<ComparisonResult> getComparisonResults(IndexReferenceInformationSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexName", (IndexName) o.getIndexName() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<IndexReferenceInformationSequence0> validate(RosettaPath path, IndexReferenceInformationSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexReferenceInformationSequence0", ValidationType.CARDINALITY, "IndexReferenceInformationSequence0", path, "", error);
		}
		return success("IndexReferenceInformationSequence0", ValidationType.CARDINALITY, "IndexReferenceInformationSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexReferenceInformationSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexReferenceInformationSequence0", ValidationType.CARDINALITY, "IndexReferenceInformationSequence0", path, "", res.getError());
				}
				return success("IndexReferenceInformationSequence0", ValidationType.CARDINALITY, "IndexReferenceInformationSequence0", path, "");
			})
			.collect(toList());
	}

}
