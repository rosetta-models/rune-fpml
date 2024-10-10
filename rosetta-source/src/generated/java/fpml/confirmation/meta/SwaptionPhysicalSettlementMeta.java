package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.validation.SwaptionPhysicalSettlementTypeFormatValidator;
import fpml.confirmation.validation.SwaptionPhysicalSettlementValidator;
import fpml.confirmation.validation.exists.SwaptionPhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SwaptionPhysicalSettlement.class)
public class SwaptionPhysicalSettlementMeta implements RosettaMetaData<SwaptionPhysicalSettlement> {

	@Override
	public List<Validator<? super SwaptionPhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwaptionPhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SwaptionPhysicalSettlement> validator() {
		return new SwaptionPhysicalSettlementValidator();
	}

	@Override
	public Validator<? super SwaptionPhysicalSettlement> typeFormatValidator() {
		return new SwaptionPhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwaptionPhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new SwaptionPhysicalSettlementOnlyExistsValidator();
	}
}
