package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCoreDetailsModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCoreDetailsModelSequenceValidator implements Validator<FxCoreDetailsModelSequence> {

	private List<ComparisonResult> getComparisonResults(FxCoreDetailsModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency1ValueDate", (Date) o.getCurrency1ValueDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency2ValueDate", (Date) o.getCurrency2ValueDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxCoreDetailsModelSequence> validate(RosettaPath path, FxCoreDetailsModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCoreDetailsModelSequence", ValidationType.CARDINALITY, "FxCoreDetailsModelSequence", path, "", error);
		}
		return success("FxCoreDetailsModelSequence", ValidationType.CARDINALITY, "FxCoreDetailsModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCoreDetailsModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCoreDetailsModelSequence", ValidationType.CARDINALITY, "FxCoreDetailsModelSequence", path, "", res.getError());
				}
				return success("FxCoreDetailsModelSequence", ValidationType.CARDINALITY, "FxCoreDetailsModelSequence", path, "");
			})
			.collect(toList());
	}

}
