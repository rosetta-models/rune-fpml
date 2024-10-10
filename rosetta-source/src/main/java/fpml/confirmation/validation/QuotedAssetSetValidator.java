package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InstrumentSet;
import fpml.confirmation.QuotedAssetSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotedAssetSetValidator implements Validator<QuotedAssetSet> {

	private List<ComparisonResult> getComparisonResults(QuotedAssetSet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("instrumentSet", (InstrumentSet) o.getInstrumentSet() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<QuotedAssetSet> validate(RosettaPath path, QuotedAssetSet o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuotedAssetSet", ValidationType.CARDINALITY, "QuotedAssetSet", path, "", error);
		}
		return success("QuotedAssetSet", ValidationType.CARDINALITY, "QuotedAssetSet", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotedAssetSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotedAssetSet", ValidationType.CARDINALITY, "QuotedAssetSet", path, "", res.getError());
				}
				return success("QuotedAssetSet", ValidationType.CARDINALITY, "QuotedAssetSet", path, "");
			})
			.collect(toList());
	}

}
