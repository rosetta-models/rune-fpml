package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InformationSource;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ObservedPrice;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObservedPriceValidator implements Validator<ObservedPrice> {

	private List<ComparisonResult> getComparisonResults(ObservedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", (NonNegativeMoney) o.getPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (LocalTime) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ObservedPrice> validate(RosettaPath path, ObservedPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObservedPrice", ValidationType.CARDINALITY, "ObservedPrice", path, "", error);
		}
		return success("ObservedPrice", ValidationType.CARDINALITY, "ObservedPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservedPrice", ValidationType.CARDINALITY, "ObservedPrice", path, "", res.getError());
				}
				return success("ObservedPrice", ValidationType.CARDINALITY, "ObservedPrice", path, "");
			})
			.collect(toList());
	}

}
