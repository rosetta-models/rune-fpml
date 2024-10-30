package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentTradePrincipal;
import fpml.confirmation.validation.InstrumentTradePrincipalTypeFormatValidator;
import fpml.confirmation.validation.InstrumentTradePrincipalValidator;
import fpml.confirmation.validation.exists.InstrumentTradePrincipalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InstrumentTradePrincipal.class)
public class InstrumentTradePrincipalMeta implements RosettaMetaData<InstrumentTradePrincipal> {

	@Override
	public List<Validator<? super InstrumentTradePrincipal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentTradePrincipal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentTradePrincipal> validator() {
		return new InstrumentTradePrincipalValidator();
	}

	@Override
	public Validator<? super InstrumentTradePrincipal> typeFormatValidator() {
		return new InstrumentTradePrincipalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentTradePrincipal, Set<String>> onlyExistsValidator() {
		return new InstrumentTradePrincipalOnlyExistsValidator();
	}
}
