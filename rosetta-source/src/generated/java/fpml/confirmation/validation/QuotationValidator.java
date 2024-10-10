package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Quotation;
import fpml.confirmation.QuotationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotationValidator implements Validator<Quotation> {

	private List<ComparisonResult> getComparisonResults(Quotation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotationModel", (QuotationModel) o.getQuotationModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Quotation> validate(RosettaPath path, Quotation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Quotation", ValidationType.CARDINALITY, "Quotation", path, "", error);
		}
		return success("Quotation", ValidationType.CARDINALITY, "Quotation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quotation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Quotation", ValidationType.CARDINALITY, "Quotation", path, "", res.getError());
				}
				return success("Quotation", ValidationType.CARDINALITY, "Quotation", path, "");
			})
			.collect(toList());
	}

}
