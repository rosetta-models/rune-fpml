package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexAnnexSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndexAnnexSourceValidator implements Validator<IndexAnnexSource> {

	private List<ComparisonResult> getComparisonResults(IndexAnnexSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexAnnexSourceScheme", (String) o.getIndexAnnexSourceScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IndexAnnexSource> validate(RosettaPath path, IndexAnnexSource o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexAnnexSource", ValidationType.CARDINALITY, "IndexAnnexSource", path, "", error);
		}
		return success("IndexAnnexSource", ValidationType.CARDINALITY, "IndexAnnexSource", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexAnnexSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexAnnexSource", ValidationType.CARDINALITY, "IndexAnnexSource", path, "", res.getError());
				}
				return success("IndexAnnexSource", ValidationType.CARDINALITY, "IndexAnnexSource", path, "");
			})
			.collect(toList());
	}

}
