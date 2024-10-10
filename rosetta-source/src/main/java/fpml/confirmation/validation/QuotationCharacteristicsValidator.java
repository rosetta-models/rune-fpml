package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.QuotationCharacteristicsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotationCharacteristicsValidator implements Validator<QuotationCharacteristics> {

	private List<ComparisonResult> getComparisonResults(QuotationCharacteristics o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotationCharacteristicsModel", (QuotationCharacteristicsModel) o.getQuotationCharacteristicsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<QuotationCharacteristics> validate(RosettaPath path, QuotationCharacteristics o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuotationCharacteristics", ValidationType.CARDINALITY, "QuotationCharacteristics", path, "", error);
		}
		return success("QuotationCharacteristics", ValidationType.CARDINALITY, "QuotationCharacteristics", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotationCharacteristics o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotationCharacteristics", ValidationType.CARDINALITY, "QuotationCharacteristics", path, "", res.getError());
				}
				return success("QuotationCharacteristics", ValidationType.CARDINALITY, "QuotationCharacteristics", path, "");
			})
			.collect(toList());
	}

}
