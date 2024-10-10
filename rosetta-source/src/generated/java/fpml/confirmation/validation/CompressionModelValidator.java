package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CompressionActivity;
import fpml.confirmation.CompressionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompressionModelValidator implements Validator<CompressionModel> {

	private List<ComparisonResult> getComparisonResults(CompressionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("compressionActivity", (CompressionActivity) o.getCompressionActivity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CompressionModel> validate(RosettaPath path, CompressionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CompressionModel", ValidationType.CARDINALITY, "CompressionModel", path, "", error);
		}
		return success("CompressionModel", ValidationType.CARDINALITY, "CompressionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompressionModel", ValidationType.CARDINALITY, "CompressionModel", path, "", res.getError());
				}
				return success("CompressionModel", ValidationType.CARDINALITY, "CompressionModel", path, "");
			})
			.collect(toList());
	}

}
