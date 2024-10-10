package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.GasPhysicalQuantitySequence;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasPhysicalQuantitySequenceValidator implements Validator<GasPhysicalQuantitySequence> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalQuantitySequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("minPhysicalQuantity", (List<? extends CommodityNotionalQuantity>) o.getMinPhysicalQuantity() == null ? 0 : ((List<? extends CommodityNotionalQuantity>) o.getMinPhysicalQuantity()).size(), 1, 0), 
				checkCardinality("maxPhysicalQuantity", (List<? extends CommodityNotionalQuantity>) o.getMaxPhysicalQuantity() == null ? 0 : ((List<? extends CommodityNotionalQuantity>) o.getMaxPhysicalQuantity()).size(), 1, 0), 
				checkCardinality("electingParty", (PartyReference) o.getElectingParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GasPhysicalQuantitySequence> validate(RosettaPath path, GasPhysicalQuantitySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasPhysicalQuantitySequence", ValidationType.CARDINALITY, "GasPhysicalQuantitySequence", path, "", error);
		}
		return success("GasPhysicalQuantitySequence", ValidationType.CARDINALITY, "GasPhysicalQuantitySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalQuantitySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalQuantitySequence", ValidationType.CARDINALITY, "GasPhysicalQuantitySequence", path, "", res.getError());
				}
				return success("GasPhysicalQuantitySequence", ValidationType.CARDINALITY, "GasPhysicalQuantitySequence", path, "");
			})
			.collect(toList());
	}

}
