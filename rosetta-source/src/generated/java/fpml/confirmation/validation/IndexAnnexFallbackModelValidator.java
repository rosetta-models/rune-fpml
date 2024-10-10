package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndexAnnexFallbackModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndexAnnexFallbackModelValidator implements Validator<IndexAnnexFallbackModel> {

	private List<ComparisonResult> getComparisonResults(IndexAnnexFallbackModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("multipleExchangeIndexAnnexFallback", (Boolean) o.getMultipleExchangeIndexAnnexFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("componentSecurityIndexAnnexFallback", (Boolean) o.getComponentSecurityIndexAnnexFallback() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IndexAnnexFallbackModel> validate(RosettaPath path, IndexAnnexFallbackModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndexAnnexFallbackModel", ValidationType.CARDINALITY, "IndexAnnexFallbackModel", path, "", error);
		}
		return success("IndexAnnexFallbackModel", ValidationType.CARDINALITY, "IndexAnnexFallbackModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexAnnexFallbackModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexAnnexFallbackModel", ValidationType.CARDINALITY, "IndexAnnexFallbackModel", path, "", res.getError());
				}
				return success("IndexAnnexFallbackModel", ValidationType.CARDINALITY, "IndexAnnexFallbackModel", path, "");
			})
			.collect(toList());
	}

}
